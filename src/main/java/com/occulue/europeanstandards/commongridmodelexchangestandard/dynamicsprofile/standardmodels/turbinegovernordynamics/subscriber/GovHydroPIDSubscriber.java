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
 * Subscriber for GovHydroPID related events. .
 *
 * @author your_name_here
 */
@Component("govHydroPID-subscriber")
public class GovHydroPIDSubscriber extends BaseSubscriber {

  public GovHydroPIDSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovHydroPID>, GovHydroPID> govHydroPIDSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovHydroPIDQuery(),
        ResponseTypes.multipleInstancesOf(GovHydroPID.class),
        ResponseTypes.instanceOf(GovHydroPID.class));
  }

  public SubscriptionQueryResult<GovHydroPID, GovHydroPID> govHydroPIDSubscribe(
      @DestinationVariable UUID govHydroPIDId) {
    return queryGateway.subscriptionQuery(
        new FindGovHydroPIDQuery(new LoadGovHydroPIDFilter(govHydroPIDId)),
        ResponseTypes.instanceOf(GovHydroPID.class),
        ResponseTypes.instanceOf(GovHydroPID.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
