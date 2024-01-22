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
 * Subscriber for OverexcLimIEEE related events. .
 *
 * @author your_name_here
 */
@Component("overexcLimIEEE-subscriber")
public class OverexcLimIEEESubscriber extends BaseSubscriber {

  public OverexcLimIEEESubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<OverexcLimIEEE>, OverexcLimIEEE> overexcLimIEEESubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllOverexcLimIEEEQuery(),
        ResponseTypes.multipleInstancesOf(OverexcLimIEEE.class),
        ResponseTypes.instanceOf(OverexcLimIEEE.class));
  }

  public SubscriptionQueryResult<OverexcLimIEEE, OverexcLimIEEE> overexcLimIEEESubscribe(
      @DestinationVariable UUID overexcLimIEEEId) {
    return queryGateway.subscriptionQuery(
        new FindOverexcLimIEEEQuery(new LoadOverexcLimIEEEFilter(overexcLimIEEEId)),
        ResponseTypes.instanceOf(OverexcLimIEEE.class),
        ResponseTypes.instanceOf(OverexcLimIEEE.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
