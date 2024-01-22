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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.subscriber;

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
 * Subscriber for PFVArControllerType2Dynamics related events. .
 *
 * @author your_name_here
 */
@Component("pFVArControllerType2Dynamics-subscriber")
public class PFVArControllerType2DynamicsSubscriber extends BaseSubscriber {

  public PFVArControllerType2DynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PFVArControllerType2Dynamics>, PFVArControllerType2Dynamics>
      pFVArControllerType2DynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPFVArControllerType2DynamicsQuery(),
        ResponseTypes.multipleInstancesOf(PFVArControllerType2Dynamics.class),
        ResponseTypes.instanceOf(PFVArControllerType2Dynamics.class));
  }

  public SubscriptionQueryResult<PFVArControllerType2Dynamics, PFVArControllerType2Dynamics>
      pFVArControllerType2DynamicsSubscribe(
          @DestinationVariable UUID pFVArControllerType2DynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindPFVArControllerType2DynamicsQuery(
            new LoadPFVArControllerType2DynamicsFilter(pFVArControllerType2DynamicsId)),
        ResponseTypes.instanceOf(PFVArControllerType2Dynamics.class),
        ResponseTypes.instanceOf(PFVArControllerType2Dynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
