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
 * Subscriber for GovHydroPelton related events. .
 *
 * @author your_name_here
 */
@Component("govHydroPelton-subscriber")
public class GovHydroPeltonSubscriber extends BaseSubscriber {

  public GovHydroPeltonSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydroPelton>, GovHydroPelton> govHydroPeltonSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydroPeltonQuery(),
        ResponseTypes.multipleInstancesOf(GovHydroPelton.class),
        ResponseTypes.instanceOf(GovHydroPelton.class));
  }

  public SubscriptionQueryResult<GovHydroPelton, GovHydroPelton> govHydroPeltonSubscribe(
      @DestinationVariable UUID govHydroPeltonId) {
    return queryGateway.subscriptionQuery(
        new FindGovHydroPeltonQuery(new LoadGovHydroPeltonFilter(govHydroPeltonId)),
        ResponseTypes.instanceOf(GovHydroPelton.class),
        ResponseTypes.instanceOf(GovHydroPelton.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
