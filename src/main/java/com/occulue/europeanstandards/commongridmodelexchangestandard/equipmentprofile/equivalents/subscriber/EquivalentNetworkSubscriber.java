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
 * Subscriber for EquivalentNetwork related events. .
 *
 * @author your_name_here
 */
@Component("equivalentNetwork-subscriber")
public class EquivalentNetworkSubscriber extends BaseSubscriber {

  public EquivalentNetworkSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EquivalentNetwork>, EquivalentNetwork>
      equivalentNetworkSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEquivalentNetworkQuery(),
        ResponseTypes.multipleInstancesOf(EquivalentNetwork.class),
        ResponseTypes.instanceOf(EquivalentNetwork.class));
  }

  public SubscriptionQueryResult<EquivalentNetwork, EquivalentNetwork> equivalentNetworkSubscribe(
      @DestinationVariable UUID equivalentNetworkId) {
    return queryGateway.subscriptionQuery(
        new FindEquivalentNetworkQuery(new LoadEquivalentNetworkFilter(equivalentNetworkId)),
        ResponseTypes.instanceOf(EquivalentNetwork.class),
        ResponseTypes.instanceOf(EquivalentNetwork.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
