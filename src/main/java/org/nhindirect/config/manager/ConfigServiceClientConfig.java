package org.nhindirect.config.manager;

import org.nhind.config.rest.AnchorService;
import org.nhind.config.rest.CertPolicyService;
import org.nhind.config.rest.CertificateService;
import org.nhind.config.rest.DNSService;
import org.nhind.config.rest.DomainService;
import org.nhind.config.rest.SettingService;
import org.nhind.config.rest.TrustBundleService;
import org.nhind.config.rest.feign.AnchorClient;
import org.nhind.config.rest.feign.CertificateClient;
import org.nhind.config.rest.feign.CertificatePolicyClient;
import org.nhind.config.rest.feign.DNSClient;
import org.nhind.config.rest.feign.DomainClient;
import org.nhind.config.rest.feign.SettingClient;
import org.nhind.config.rest.feign.TrustBundleClient;
import org.nhind.config.rest.impl.DefaultAnchorService;
import org.nhind.config.rest.impl.DefaultCertPolicyService;
import org.nhind.config.rest.impl.DefaultCertificateService;
import org.nhind.config.rest.impl.DefaultDNSService;
import org.nhind.config.rest.impl.DefaultDomainService;
import org.nhind.config.rest.impl.DefaultSettingService;
import org.nhind.config.rest.impl.DefaultTrustBundleService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients({"org.nhind.config.rest.feign"})
public class ConfigServiceClientConfig
{
	@Bean
	@ConditionalOnMissingBean
	public CertificateService certificateService(CertificateClient certClient)
	{
		return new DefaultCertificateService(certClient);
	}
	
	@Bean
	@ConditionalOnMissingBean
	public TrustBundleService trustBundleService(TrustBundleClient bundleClient)
	{
		return new DefaultTrustBundleService(bundleClient);
	}	
	
	@Bean
	@ConditionalOnMissingBean
	public DomainService domainService(DomainClient domainClient)
	{
		return new DefaultDomainService(domainClient);
	}	
	
	@Bean
	@ConditionalOnMissingBean
	public AnchorService anchorService(AnchorClient anchorClient)
	{
		return new DefaultAnchorService(anchorClient);
	}	
	
	@Bean
	@ConditionalOnMissingBean
	public CertPolicyService certPolicyService(CertificatePolicyClient polClient)
	{
		return new DefaultCertPolicyService(polClient);
	}	
	
	@Bean
	@ConditionalOnMissingBean
	public SettingService settingService(SettingClient settingClient)
	{
		return new DefaultSettingService(settingClient);
	}	
	
	@Bean
	@ConditionalOnMissingBean
	public DNSService dnsService(DNSClient dnsClient)
	{
		return new DefaultDNSService(dnsClient);
	}		
}
