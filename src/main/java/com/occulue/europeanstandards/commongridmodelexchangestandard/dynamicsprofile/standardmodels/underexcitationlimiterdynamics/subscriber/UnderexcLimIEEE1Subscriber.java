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
 * Subscriber for UnderexcLimIEEE1 related events. .
 *
 * @author your_name_here
 */
@Component("underexcLimIEEE1-subscriber")
public class UnderexcLimIEEE1Subscriber extends BaseSubscriber {

  public UnderexcLimIEEE1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<UnderexcLimIEEE1>, UnderexcLimIEEE1>
      underexcLimIEEE1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllUnderexcLimIEEE1Query(),
        ResponseTypes.multipleInstancesOf(UnderexcLimIEEE1.class),
        ResponseTypes.instanceOf(UnderexcLimIEEE1.class));
  }

  public SubscriptionQueryResult<UnderexcLimIEEE1, UnderexcLimIEEE1> underexcLimIEEE1Subscribe(
      @DestinationVariable UUID underexcLimIEEE1Id) {
    return queryGateway.subscriptionQuery(
        new FindUnderexcLimIEEE1Query(new LoadUnderexcLimIEEE1Filter(underexcLimIEEE1Id)),
        ResponseTypes.instanceOf(UnderexcLimIEEE1.class),
        ResponseTypes.instanceOf(UnderexcLimIEEE1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
