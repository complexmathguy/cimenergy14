/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for ExcitationSystemDynamics related events. .
 *
 * @author your_name_here
 */
@Component("excitationSystemDynamics-subscriber")
public class ExcitationSystemDynamicsSubscriber extends BaseSubscriber {

  public ExcitationSystemDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcitationSystemDynamics>, ExcitationSystemDynamics>
      excitationSystemDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcitationSystemDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(ExcitationSystemDynamics.class),
        ResponseTypes.instanceOf(ExcitationSystemDynamics.class));
  }

  public SubscriptionQueryResult<ExcitationSystemDynamics, ExcitationSystemDynamics>
      excitationSystemDynamicsSubscribe(@DestinationVariable UUID excitationSystemDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindExcitationSystemDynamicsQuery(
            new LoadExcitationSystemDynamicsFilter(excitationSystemDynamicsId)),
        ResponseTypes.instanceOf(ExcitationSystemDynamics.class),
        ResponseTypes.instanceOf(ExcitationSystemDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
