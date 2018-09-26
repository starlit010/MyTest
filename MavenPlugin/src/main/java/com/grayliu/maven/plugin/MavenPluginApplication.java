package com.grayliu.maven.plugin;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MavenPluginApplication extends AbstractMojo {

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		Map map = getPluginContext();
		Set entrySet = map.entrySet();
		Iterator iterator = entrySet.iterator();
		getLog().info("hello world");
		while(iterator.hasNext()){
			getLog().info(iterator.next().toString());
		}


	}
}
