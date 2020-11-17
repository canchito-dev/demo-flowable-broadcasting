package org.flowable.broadcasting.demo.demoflowablecore.configuration;

import org.flowable.cmmn.api.CmmnRepositoryService;
import org.flowable.dmn.api.DmnRepositoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.eventregistry.api.EventRepositoryService;
import org.flowable.form.api.FormRepositoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineRunnerConfiguration {

    @Bean
    public CommandLineRunner init(final RepositoryService processRepositoryService,
                                  final CmmnRepositoryService caseRepositoryService,
                                  final DmnRepositoryService dmnRepositoryService,
                                  final FormRepositoryService formRepositoryService,
                                  final EventRepositoryService eventRepositoryService) {

        return strings -> {
            System.out.println("Number of process definitions : " + processRepositoryService.createProcessDefinitionQuery().count());
            System.out.println("Number of case definitions : " + caseRepositoryService.createCaseDefinitionQuery().count());
            System.out.println("Number of dmn definitions : " + dmnRepositoryService.createDecisionQuery().count());
            System.out.println("Number of form definitions : " + formRepositoryService.createFormDefinitionQuery().count());

            System.out.println("Number of channel definitions : " + eventRepositoryService.createChannelDefinitionQuery().count());
            System.out.println("Number of event definitions : " + eventRepositoryService.createEventDefinitionQuery().count());
        };
    }
}
