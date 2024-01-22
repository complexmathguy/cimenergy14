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
 * Subscriber for GovSteamFV2 related events. .
 *
 * @author your_name_here
 */
@Component("govSteamFV2-subscriber")
public class GovSteamFV2Subscriber extends BaseSubscriber {

  public GovSteamFV2Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovSteamFV2>, GovSteamFV2> govSteamFV2Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovSteamFV2Query(),
        ResponseTypes.multipleInstancesOf(GovSteamFV2.class),
        ResponseTypes.instanceOf(GovSteamFV2.class));
  }

  public SubscriptionQueryResult<GovSteamFV2, GovSteamFV2> govSteamFV2Subscribe(
      @DestinationVariable UUID govSteamFV2Id) {
    return queryGateway.subscriptionQuery(
        new FindGovSteamFV2Query(new LoadGovSteamFV2Filter(govSteamFV2Id)),
        ResponseTypes.instanceOf(GovSteamFV2.class),
        ResponseTypes.instanceOf(GovSteamFV2.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
