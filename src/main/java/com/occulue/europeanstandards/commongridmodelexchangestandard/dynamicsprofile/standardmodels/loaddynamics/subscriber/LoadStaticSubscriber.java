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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.subscriber;

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
 * Subscriber for LoadStatic related events. .
 *
 * @author your_name_here
 */
@Component("loadStatic-subscriber")
public class LoadStaticSubscriber extends BaseSubscriber {

  public LoadStaticSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<LoadStatic>, LoadStatic> loadStaticSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLoadStaticQuery(),
        ResponseTypes.multipleInstancesOf(LoadStatic.class),
        ResponseTypes.instanceOf(LoadStatic.class));
  }

  public SubscriptionQueryResult<LoadStatic, LoadStatic> loadStaticSubscribe(
      @DestinationVariable UUID loadStaticId) {
    return queryGateway.subscriptionQuery(
        new FindLoadStaticQuery(new LoadLoadStaticFilter(loadStaticId)),
        ResponseTypes.instanceOf(LoadStatic.class),
        ResponseTypes.instanceOf(LoadStatic.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
