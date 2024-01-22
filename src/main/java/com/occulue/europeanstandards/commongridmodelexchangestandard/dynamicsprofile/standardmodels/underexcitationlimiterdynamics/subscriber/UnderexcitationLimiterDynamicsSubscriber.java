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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.subscriber;

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
 * Subscriber for UnderexcitationLimiterDynamics related events. .
 *
 * @author your_name_here
 */
@Component("underexcitationLimiterDynamics-subscriber")
public class UnderexcitationLimiterDynamicsSubscriber extends BaseSubscriber {

  public UnderexcitationLimiterDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<UnderexcitationLimiterDynamics>, UnderexcitationLimiterDynamics>
      underexcitationLimiterDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllUnderexcitationLimiterDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(UnderexcitationLimiterDynamics.class),
        ResponseTypes.instanceOf(UnderexcitationLimiterDynamics.class));
  }

  public SubscriptionQueryResult<UnderexcitationLimiterDynamics, UnderexcitationLimiterDynamics>
      underexcitationLimiterDynamicsSubscribe(
          @DestinationVariable UUID underexcitationLimiterDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindUnderexcitationLimiterDynamicsQuery(
            new LoadUnderexcitationLimiterDynamicsFilter(underexcitationLimiterDynamicsId)),
        ResponseTypes.instanceOf(UnderexcitationLimiterDynamics.class),
        ResponseTypes.instanceOf(UnderexcitationLimiterDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
