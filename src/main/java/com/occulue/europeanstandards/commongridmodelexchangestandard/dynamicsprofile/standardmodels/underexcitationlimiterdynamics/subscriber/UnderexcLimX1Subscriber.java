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
 * Subscriber for UnderexcLimX1 related events. .
 *
 * @author your_name_here
 */
@Component("underexcLimX1-subscriber")
public class UnderexcLimX1Subscriber extends BaseSubscriber {

  public UnderexcLimX1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<UnderexcLimX1>, UnderexcLimX1> underexcLimX1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllUnderexcLimX1Query(),
        ResponseTypes.multipleInstancesOf(UnderexcLimX1.class),
        ResponseTypes.instanceOf(UnderexcLimX1.class));
  }

  public SubscriptionQueryResult<UnderexcLimX1, UnderexcLimX1> underexcLimX1Subscribe(
      @DestinationVariable UUID underexcLimX1Id) {
    return queryGateway.subscriptionQuery(
        new FindUnderexcLimX1Query(new LoadUnderexcLimX1Filter(underexcLimX1Id)),
        ResponseTypes.instanceOf(UnderexcLimX1.class),
        ResponseTypes.instanceOf(UnderexcLimX1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
