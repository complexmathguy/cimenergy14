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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.subscriber;

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
 * Subscriber for Quality61850 related events. .
 *
 * @author your_name_here
 */
@Component("quality61850-subscriber")
public class Quality61850Subscriber extends BaseSubscriber {

  public Quality61850Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Quality61850>, Quality61850> quality61850Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllQuality61850Query(),
        ResponseTypes.multipleInstancesOf(Quality61850.class),
        ResponseTypes.instanceOf(Quality61850.class));
  }

  public SubscriptionQueryResult<Quality61850, Quality61850> quality61850Subscribe(
      @DestinationVariable UUID quality61850Id) {
    return queryGateway.subscriptionQuery(
        new FindQuality61850Query(new LoadQuality61850Filter(quality61850Id)),
        ResponseTypes.instanceOf(Quality61850.class),
        ResponseTypes.instanceOf(Quality61850.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
