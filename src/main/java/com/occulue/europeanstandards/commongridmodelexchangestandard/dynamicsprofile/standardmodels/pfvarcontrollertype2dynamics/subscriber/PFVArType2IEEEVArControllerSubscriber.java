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
 * Subscriber for PFVArType2IEEEVArController related events. .
 *
 * @author your_name_here
 */
@Component("pFVArType2IEEEVArController-subscriber")
public class PFVArType2IEEEVArControllerSubscriber extends BaseSubscriber {

  public PFVArType2IEEEVArControllerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PFVArType2IEEEVArController>, PFVArType2IEEEVArController>
      pFVArType2IEEEVArControllerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPFVArType2IEEEVArControllerQuery(),
        ResponseTypes.multipleInstancesOf(PFVArType2IEEEVArController.class),
        ResponseTypes.instanceOf(PFVArType2IEEEVArController.class));
  }

  public SubscriptionQueryResult<PFVArType2IEEEVArController, PFVArType2IEEEVArController>
      pFVArType2IEEEVArControllerSubscribe(
          @DestinationVariable UUID pFVArType2IEEEVArControllerId) {
    return queryGateway.subscriptionQuery(
        new FindPFVArType2IEEEVArControllerQuery(
            new LoadPFVArType2IEEEVArControllerFilter(pFVArType2IEEEVArControllerId)),
        ResponseTypes.instanceOf(PFVArType2IEEEVArController.class),
        ResponseTypes.instanceOf(PFVArType2IEEEVArController.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
