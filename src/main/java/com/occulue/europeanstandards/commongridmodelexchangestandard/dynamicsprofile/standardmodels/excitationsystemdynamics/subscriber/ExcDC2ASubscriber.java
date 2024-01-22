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
 * Subscriber for ExcDC2A related events. .
 *
 * @author your_name_here
 */
@Component("excDC2A-subscriber")
public class ExcDC2ASubscriber extends BaseSubscriber {

  public ExcDC2ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcDC2A>, ExcDC2A> excDC2ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcDC2AQuery(),
        ResponseTypes.multipleInstancesOf(ExcDC2A.class),
        ResponseTypes.instanceOf(ExcDC2A.class));
  }

  public SubscriptionQueryResult<ExcDC2A, ExcDC2A> excDC2ASubscribe(
      @DestinationVariable UUID excDC2AId) {
    return queryGateway.subscriptionQuery(
        new FindExcDC2AQuery(new LoadExcDC2AFilter(excDC2AId)),
        ResponseTypes.instanceOf(ExcDC2A.class),
        ResponseTypes.instanceOf(ExcDC2A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
