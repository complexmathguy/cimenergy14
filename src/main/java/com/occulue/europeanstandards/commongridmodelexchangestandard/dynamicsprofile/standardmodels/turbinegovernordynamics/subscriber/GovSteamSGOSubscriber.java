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
 * Subscriber for GovSteamSGO related events. .
 *
 * @author your_name_here
 */
@Component("govSteamSGO-subscriber")
public class GovSteamSGOSubscriber extends BaseSubscriber {

  public GovSteamSGOSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovSteamSGO>, GovSteamSGO> govSteamSGOSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovSteamSGOQuery(),
        ResponseTypes.multipleInstancesOf(GovSteamSGO.class),
        ResponseTypes.instanceOf(GovSteamSGO.class));
  }

  public SubscriptionQueryResult<GovSteamSGO, GovSteamSGO> govSteamSGOSubscribe(
      @DestinationVariable UUID govSteamSGOId) {
    return queryGateway.subscriptionQuery(
        new FindGovSteamSGOQuery(new LoadGovSteamSGOFilter(govSteamSGOId)),
        ResponseTypes.instanceOf(GovSteamSGO.class),
        ResponseTypes.instanceOf(GovSteamSGO.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
