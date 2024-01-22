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
 * Subscriber for Pss1A related events. .
 *
 * @author your_name_here
 */
@Component("pss1A-subscriber")
public class Pss1ASubscriber extends BaseSubscriber {

  public Pss1ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Pss1A>, Pss1A> pss1ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPss1AQuery(),
        ResponseTypes.multipleInstancesOf(Pss1A.class),
        ResponseTypes.instanceOf(Pss1A.class));
  }

  public SubscriptionQueryResult<Pss1A, Pss1A> pss1ASubscribe(@DestinationVariable UUID pss1AId) {
    return queryGateway.subscriptionQuery(
        new FindPss1AQuery(new LoadPss1AFilter(pss1AId)),
        ResponseTypes.instanceOf(Pss1A.class),
        ResponseTypes.instanceOf(Pss1A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
