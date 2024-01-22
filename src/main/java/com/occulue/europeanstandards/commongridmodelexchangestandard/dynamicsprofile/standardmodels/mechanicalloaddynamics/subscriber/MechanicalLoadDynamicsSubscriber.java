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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.subscriber;

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
 * Subscriber for MechanicalLoadDynamics related events. .
 *
 * @author your_name_here
 */
@Component("mechanicalLoadDynamics-subscriber")
public class MechanicalLoadDynamicsSubscriber extends BaseSubscriber {

  public MechanicalLoadDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<MechanicalLoadDynamics>, MechanicalLoadDynamics>
      mechanicalLoadDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllMechanicalLoadDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(MechanicalLoadDynamics.class),
        ResponseTypes.instanceOf(MechanicalLoadDynamics.class));
  }

  public SubscriptionQueryResult<MechanicalLoadDynamics, MechanicalLoadDynamics>
      mechanicalLoadDynamicsSubscribe(@DestinationVariable UUID mechanicalLoadDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindMechanicalLoadDynamicsQuery(
            new LoadMechanicalLoadDynamicsFilter(mechanicalLoadDynamicsId)),
        ResponseTypes.instanceOf(MechanicalLoadDynamics.class),
        ResponseTypes.instanceOf(MechanicalLoadDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
