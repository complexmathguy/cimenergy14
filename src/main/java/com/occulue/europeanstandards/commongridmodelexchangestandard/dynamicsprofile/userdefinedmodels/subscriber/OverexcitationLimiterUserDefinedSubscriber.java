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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.subscriber;

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
 * Subscriber for OverexcitationLimiterUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("overexcitationLimiterUserDefined-subscriber")
public class OverexcitationLimiterUserDefinedSubscriber extends BaseSubscriber {

  public OverexcitationLimiterUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<OverexcitationLimiterUserDefined>, OverexcitationLimiterUserDefined>
      overexcitationLimiterUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllOverexcitationLimiterUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(OverexcitationLimiterUserDefined.class),
        ResponseTypes.instanceOf(OverexcitationLimiterUserDefined.class));
  }

  public SubscriptionQueryResult<OverexcitationLimiterUserDefined, OverexcitationLimiterUserDefined>
      overexcitationLimiterUserDefinedSubscribe(
          @DestinationVariable UUID overexcitationLimiterUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindOverexcitationLimiterUserDefinedQuery(
            new LoadOverexcitationLimiterUserDefinedFilter(overexcitationLimiterUserDefinedId)),
        ResponseTypes.instanceOf(OverexcitationLimiterUserDefined.class),
        ResponseTypes.instanceOf(OverexcitationLimiterUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
