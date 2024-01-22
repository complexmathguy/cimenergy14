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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype1dynamics.subscriber;

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
 * Subscriber for PFVArType1IEEEVArController related events. .
 *
 * @author your_name_here
 */
@Component("pFVArType1IEEEVArController-subscriber")
public class PFVArType1IEEEVArControllerSubscriber extends BaseSubscriber {

  public PFVArType1IEEEVArControllerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PFVArType1IEEEVArController>, PFVArType1IEEEVArController>
      pFVArType1IEEEVArControllerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPFVArType1IEEEVArControllerQuery(),
        ResponseTypes.multipleInstancesOf(PFVArType1IEEEVArController.class),
        ResponseTypes.instanceOf(PFVArType1IEEEVArController.class));
  }

  public SubscriptionQueryResult<PFVArType1IEEEVArController, PFVArType1IEEEVArController>
      pFVArType1IEEEVArControllerSubscribe(
          @DestinationVariable UUID pFVArType1IEEEVArControllerId) {
    return queryGateway.subscriptionQuery(
        new FindPFVArType1IEEEVArControllerQuery(
            new LoadPFVArType1IEEEVArControllerFilter(pFVArType1IEEEVArControllerId)),
        ResponseTypes.instanceOf(PFVArType1IEEEVArController.class),
        ResponseTypes.instanceOf(PFVArType1IEEEVArController.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
