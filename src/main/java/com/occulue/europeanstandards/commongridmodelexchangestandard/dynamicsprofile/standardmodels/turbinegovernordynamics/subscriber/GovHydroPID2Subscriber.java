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
 * Subscriber for GovHydroPID2 related events. .
 *
 * @author your_name_here
 */
@Component("govHydroPID2-subscriber")
public class GovHydroPID2Subscriber extends BaseSubscriber {

  public GovHydroPID2Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydroPID2>, GovHydroPID2> govHydroPID2Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydroPID2Query(),
        ResponseTypes.multipleInstancesOf(GovHydroPID2.class),
        ResponseTypes.instanceOf(GovHydroPID2.class));
  }

  public SubscriptionQueryResult<GovHydroPID2, GovHydroPID2> govHydroPID2Subscribe(
      @DestinationVariable UUID govHydroPID2Id) {
    return queryGateway.subscriptionQuery(
        new FindGovHydroPID2Query(new LoadGovHydroPID2Filter(govHydroPID2Id)),
        ResponseTypes.instanceOf(GovHydroPID2.class),
        ResponseTypes.instanceOf(GovHydroPID2.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
