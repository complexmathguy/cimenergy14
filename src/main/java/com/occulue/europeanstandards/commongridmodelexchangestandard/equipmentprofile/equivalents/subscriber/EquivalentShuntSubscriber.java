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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.subscriber;

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
 * Subscriber for EquivalentShunt related events. .
 *
 * @author your_name_here
 */
@Component("equivalentShunt-subscriber")
public class EquivalentShuntSubscriber extends BaseSubscriber {

  public EquivalentShuntSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EquivalentShunt>, EquivalentShunt>
      equivalentShuntSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEquivalentShuntQuery(),
        ResponseTypes.multipleInstancesOf(EquivalentShunt.class),
        ResponseTypes.instanceOf(EquivalentShunt.class));
  }

  public SubscriptionQueryResult<EquivalentShunt, EquivalentShunt> equivalentShuntSubscribe(
      @DestinationVariable UUID equivalentShuntId) {
    return queryGateway.subscriptionQuery(
        new FindEquivalentShuntQuery(new LoadEquivalentShuntFilter(equivalentShuntId)),
        ResponseTypes.instanceOf(EquivalentShunt.class),
        ResponseTypes.instanceOf(EquivalentShunt.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
