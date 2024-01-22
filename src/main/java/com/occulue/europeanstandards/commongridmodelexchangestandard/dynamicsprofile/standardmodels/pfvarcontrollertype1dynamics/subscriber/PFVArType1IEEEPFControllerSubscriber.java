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
 * Subscriber for PFVArType1IEEEPFController related events. .
 *
 * @author your_name_here
 */
@Component("pFVArType1IEEEPFController-subscriber")
public class PFVArType1IEEEPFControllerSubscriber extends BaseSubscriber {

  public PFVArType1IEEEPFControllerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PFVArType1IEEEPFController>, PFVArType1IEEEPFController>
      pFVArType1IEEEPFControllerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPFVArType1IEEEPFControllerQuery(),
        ResponseTypes.multipleInstancesOf(PFVArType1IEEEPFController.class),
        ResponseTypes.instanceOf(PFVArType1IEEEPFController.class));
  }

  public SubscriptionQueryResult<PFVArType1IEEEPFController, PFVArType1IEEEPFController>
      pFVArType1IEEEPFControllerSubscribe(@DestinationVariable UUID pFVArType1IEEEPFControllerId) {
    return queryGateway.subscriptionQuery(
        new FindPFVArType1IEEEPFControllerQuery(
            new LoadPFVArType1IEEEPFControllerFilter(pFVArType1IEEEPFControllerId)),
        ResponseTypes.instanceOf(PFVArType1IEEEPFController.class),
        ResponseTypes.instanceOf(PFVArType1IEEEPFController.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
