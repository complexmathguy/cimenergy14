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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.subscriber;

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
 * Subscriber for Bay related events. .
 *
 * @author your_name_here
 */
@Component("bay-subscriber")
public class BaySubscriber extends BaseSubscriber {

  public BaySubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Bay>, Bay> baySubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllBayQuery(),
        ResponseTypes.multipleInstancesOf(Bay.class),
        ResponseTypes.instanceOf(Bay.class));
  }

  public SubscriptionQueryResult<Bay, Bay> baySubscribe(@DestinationVariable UUID bayId) {
    return queryGateway.subscriptionQuery(
        new FindBayQuery(new LoadBayFilter(bayId)),
        ResponseTypes.instanceOf(Bay.class),
        ResponseTypes.instanceOf(Bay.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
