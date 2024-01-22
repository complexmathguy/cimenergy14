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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.overexcitationlimiterdynamics.subscriber;

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
 * Subscriber for OverexcLim2 related events. .
 *
 * @author your_name_here
 */
@Component("overexcLim2-subscriber")
public class OverexcLim2Subscriber extends BaseSubscriber {

  public OverexcLim2Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<OverexcLim2>, OverexcLim2> overexcLim2Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllOverexcLim2Query(),
        ResponseTypes.multipleInstancesOf(OverexcLim2.class),
        ResponseTypes.instanceOf(OverexcLim2.class));
  }

  public SubscriptionQueryResult<OverexcLim2, OverexcLim2> overexcLim2Subscribe(
      @DestinationVariable UUID overexcLim2Id) {
    return queryGateway.subscriptionQuery(
        new FindOverexcLim2Query(new LoadOverexcLim2Filter(overexcLim2Id)),
        ResponseTypes.instanceOf(OverexcLim2.class),
        ResponseTypes.instanceOf(OverexcLim2.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
