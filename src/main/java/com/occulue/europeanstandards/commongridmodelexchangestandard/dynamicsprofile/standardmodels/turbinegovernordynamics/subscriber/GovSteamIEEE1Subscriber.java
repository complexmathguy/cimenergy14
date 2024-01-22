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
 * Subscriber for GovSteamIEEE1 related events. .
 *
 * @author your_name_here
 */
@Component("govSteamIEEE1-subscriber")
public class GovSteamIEEE1Subscriber extends BaseSubscriber {

  public GovSteamIEEE1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovSteamIEEE1>, GovSteamIEEE1> govSteamIEEE1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovSteamIEEE1Query(),
        ResponseTypes.multipleInstancesOf(GovSteamIEEE1.class),
        ResponseTypes.instanceOf(GovSteamIEEE1.class));
  }

  public SubscriptionQueryResult<GovSteamIEEE1, GovSteamIEEE1> govSteamIEEE1Subscribe(
      @DestinationVariable UUID govSteamIEEE1Id) {
    return queryGateway.subscriptionQuery(
        new FindGovSteamIEEE1Query(new LoadGovSteamIEEE1Filter(govSteamIEEE1Id)),
        ResponseTypes.instanceOf(GovSteamIEEE1.class),
        ResponseTypes.instanceOf(GovSteamIEEE1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
