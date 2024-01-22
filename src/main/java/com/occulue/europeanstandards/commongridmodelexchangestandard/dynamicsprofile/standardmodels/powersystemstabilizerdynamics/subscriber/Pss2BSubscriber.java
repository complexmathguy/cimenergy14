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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.subscriber;

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
 * Subscriber for Pss2B related events. .
 *
 * @author your_name_here
 */
@Component("pss2B-subscriber")
public class Pss2BSubscriber extends BaseSubscriber {

  public Pss2BSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Pss2B>, Pss2B> pss2BSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPss2BQuery(),
        ResponseTypes.multipleInstancesOf(Pss2B.class),
        ResponseTypes.instanceOf(Pss2B.class));
  }

  public SubscriptionQueryResult<Pss2B, Pss2B> pss2BSubscribe(@DestinationVariable UUID pss2BId) {
    return queryGateway.subscriptionQuery(
        new FindPss2BQuery(new LoadPss2BFilter(pss2BId)),
        ResponseTypes.instanceOf(Pss2B.class),
        ResponseTypes.instanceOf(Pss2B.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
