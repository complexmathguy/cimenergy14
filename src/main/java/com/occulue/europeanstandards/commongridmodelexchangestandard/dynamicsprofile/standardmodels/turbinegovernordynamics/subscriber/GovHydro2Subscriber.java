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
 * Subscriber for GovHydro2 related events. .
 *
 * @author your_name_here
 */
@Component("govHydro2-subscriber")
public class GovHydro2Subscriber extends BaseSubscriber {

  public GovHydro2Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydro2>, GovHydro2> govHydro2Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydro2Query(),
        ResponseTypes.multipleInstancesOf(GovHydro2.class),
        ResponseTypes.instanceOf(GovHydro2.class));
  }

  public SubscriptionQueryResult<GovHydro2, GovHydro2> govHydro2Subscribe(
      @DestinationVariable UUID govHydro2Id) {
    return queryGateway.subscriptionQuery(
        new FindGovHydro2Query(new LoadGovHydro2Filter(govHydro2Id)),
        ResponseTypes.instanceOf(GovHydro2.class),
        ResponseTypes.instanceOf(GovHydro2.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
