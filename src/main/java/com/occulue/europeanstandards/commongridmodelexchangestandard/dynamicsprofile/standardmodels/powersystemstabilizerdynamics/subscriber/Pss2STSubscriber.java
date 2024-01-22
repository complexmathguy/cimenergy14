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
 * Subscriber for Pss2ST related events. .
 *
 * @author your_name_here
 */
@Component("pss2ST-subscriber")
public class Pss2STSubscriber extends BaseSubscriber {

  public Pss2STSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Pss2ST>, Pss2ST> pss2STSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPss2STQuery(),
        ResponseTypes.multipleInstancesOf(Pss2ST.class),
        ResponseTypes.instanceOf(Pss2ST.class));
  }

  public SubscriptionQueryResult<Pss2ST, Pss2ST> pss2STSubscribe(
      @DestinationVariable UUID pss2STId) {
    return queryGateway.subscriptionQuery(
        new FindPss2STQuery(new LoadPss2STFilter(pss2STId)),
        ResponseTypes.instanceOf(Pss2ST.class),
        ResponseTypes.instanceOf(Pss2ST.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
