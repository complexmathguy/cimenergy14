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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.subscriber;

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
 * Subscriber for Staticpowersystemmodel related events. .
 *
 * @author your_name_here
 */
@Component("staticpowersystemmodel-subscriber")
public class StaticpowersystemmodelSubscriber extends BaseSubscriber {

  public StaticpowersystemmodelSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Staticpowersystemmodel>, Staticpowersystemmodel>
      staticpowersystemmodelSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllStaticpowersystemmodelQuery(),
        ResponseTypes.multipleInstancesOf(Staticpowersystemmodel.class),
        ResponseTypes.instanceOf(Staticpowersystemmodel.class));
  }

  public SubscriptionQueryResult<Staticpowersystemmodel, Staticpowersystemmodel>
      staticpowersystemmodelSubscribe(@DestinationVariable UUID staticpowersystemmodelId) {
    return queryGateway.subscriptionQuery(
        new FindStaticpowersystemmodelQuery(
            new LoadStaticpowersystemmodelFilter(staticpowersystemmodelId)),
        ResponseTypes.instanceOf(Staticpowersystemmodel.class),
        ResponseTypes.instanceOf(Staticpowersystemmodel.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
