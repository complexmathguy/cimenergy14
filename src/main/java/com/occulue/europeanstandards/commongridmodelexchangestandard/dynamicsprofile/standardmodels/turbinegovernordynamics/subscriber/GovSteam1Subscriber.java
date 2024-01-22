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
 * Subscriber for GovSteam1 related events. .
 *
 * @author your_name_here
 */
@Component("govSteam1-subscriber")
public class GovSteam1Subscriber extends BaseSubscriber {

  public GovSteam1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovSteam1>, GovSteam1> govSteam1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovSteam1Query(),
        ResponseTypes.multipleInstancesOf(GovSteam1.class),
        ResponseTypes.instanceOf(GovSteam1.class));
  }

  public SubscriptionQueryResult<GovSteam1, GovSteam1> govSteam1Subscribe(
      @DestinationVariable UUID govSteam1Id) {
    return queryGateway.subscriptionQuery(
        new FindGovSteam1Query(new LoadGovSteam1Filter(govSteam1Id)),
        ResponseTypes.instanceOf(GovSteam1.class),
        ResponseTypes.instanceOf(GovSteam1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
