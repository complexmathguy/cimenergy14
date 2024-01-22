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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.subscriber;

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
 * Subscriber for GovSteam0 related events. .
 *
 * @author your_name_here
 */
@Component("govSteam0-subscriber")
public class GovSteam0Subscriber extends BaseSubscriber {

  public GovSteam0Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovSteam0>, GovSteam0> govSteam0Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovSteam0Query(),
        ResponseTypes.multipleInstancesOf(GovSteam0.class),
        ResponseTypes.instanceOf(GovSteam0.class));
  }

  public SubscriptionQueryResult<GovSteam0, GovSteam0> govSteam0Subscribe(
      @DestinationVariable UUID govSteam0Id) {
    return queryGateway.subscriptionQuery(
        new FindGovSteam0Query(new LoadGovSteam0Filter(govSteam0Id)),
        ResponseTypes.instanceOf(GovSteam0.class),
        ResponseTypes.instanceOf(GovSteam0.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
