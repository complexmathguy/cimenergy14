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
 * Subscriber for ExcAC2A related events. .
 *
 * @author your_name_here
 */
@Component("excAC2A-subscriber")
public class ExcAC2ASubscriber extends BaseSubscriber {

  public ExcAC2ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcAC2A>, ExcAC2A> excAC2ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcAC2AQuery(),
        ResponseTypes.multipleInstancesOf(ExcAC2A.class),
        ResponseTypes.instanceOf(ExcAC2A.class));
  }

  public SubscriptionQueryResult<ExcAC2A, ExcAC2A> excAC2ASubscribe(
      @DestinationVariable UUID excAC2AId) {
    return queryGateway.subscriptionQuery(
        new FindExcAC2AQuery(new LoadExcAC2AFilter(excAC2AId)),
        ResponseTypes.instanceOf(ExcAC2A.class),
        ResponseTypes.instanceOf(ExcAC2A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
