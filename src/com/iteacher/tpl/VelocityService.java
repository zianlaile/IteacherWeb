package com.iteacher.tpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
@Service
public class VelocityService implements InitializingBean {

	private Map<String, String> templateMap = new HashMap<String, String>();
	
	private String definition;
	
	private VelocityEngine ve;
	
	public VelocityService() throws ParserConfigurationException{
		ve = new VelocityEngine();
		ve.init();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(definition != null){
			ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
			Resource[] resources = resourceLoader.getResources(definition);
			if(resources != null){
				for(Resource resource : resources){
					templateMap.put(resource.getFilename(), IOUtils.toString(resource.getInputStream()));
				}
			}
		}
	}

	public void parse(String templateName, String target, Map<String, Object> params) throws Exception{
		String template = templateMap.get(templateName);
		if(template == null){
			throw new RuntimeException("template does not exists [" + templateName + "]");
		}
		VelocityContext context = new VelocityContext();
		for(Entry<String, Object> entry : params.entrySet()){
			context.put(entry.getKey(), entry.getValue());
		}
		OutputStream os = null;
		Writer writer = null;
		try{
			File file = new File(target);
			File dir = file.getParentFile();
			if(!dir.exists()){
				dir.mkdirs();
			}
			if(file.exists()){
				file.delete();
			}
			System.out.println("save file to " + target);
			os = new FileOutputStream(file);
			writer = new OutputStreamWriter(os);
			ve.evaluate(context, writer, "velocity", template);
			writer.flush();
		}catch(Exception e){
			throw e;
		}finally{
			IOUtils.closeQuietly(writer);
			IOUtils.closeQuietly(os);
		}
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
}
