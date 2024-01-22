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
 * Subscriber for UnderexcitationLimiterUserDefined related events. .
 *
 * @author your_name_here
 */
@Component("underexcitationLimiterUserDefined-subscriber")
public class UnderexcitationLimiterUserDefinedSubscriber extends BaseSubscriber {

  public UnderexcitationLimiterUserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<
          List<UnderexcitationLimiterUserDefined>, UnderexcitationLimiterUserDefined>
      underexcitationLimiterUserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllUnderexcitationLimiterUserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(UnderexcitationLimiterUserDefined.class),
        ResponseTypes.instanceOf(UnderexcitationLimiterUserDefined.class));
  }

  public SubscriptionQueryResult<
          UnderexcitationLimiterUserDefined, UnderexcitationLimiterUserDefined>
      underexcitationLimiterUserDefinedSubscribe(
          @DestinationVariable UUID underexcitationLimiterUserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindUnderexcitationLimiterUserDefinedQuery(
            new LoadUnderexcitationLimiterUserDefinedFilter(underexcitationLimiterUserDefinedId)),
        ResponseTypes.instanceOf(UnderexcitationLimiterUserDefined.class),
        ResponseTypes.instanceOf(UnderexcitationLimiterUserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
