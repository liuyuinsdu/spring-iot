package com.runhang.framework.model;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 
 * @Description: 
 * @author runhang
 * @date Oct 27, 2016 9:19:53 PM 
 *
 */
@Table(name="Fts_Candidate")
public class FtsCandidateEntity extends AbstractModel{

	private static final long serialVersionUID = -6258985888675641335L;

	@Column(name="bean_id")
	protected String beanId;
	@Column(name="bean_module")
	protected String beanModule;
	@Column(name="processed")
	protected Boolean processed;

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public String getBeanModule() {
		return beanModule;
	}

	public void setBeanModule(String beanModule) {
		this.beanModule = beanModule;
	}

	public Boolean getProcessed() {
		return processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}
	
	@Override
	public String getModule() {
		return "FtsCandidate";
	}

}
