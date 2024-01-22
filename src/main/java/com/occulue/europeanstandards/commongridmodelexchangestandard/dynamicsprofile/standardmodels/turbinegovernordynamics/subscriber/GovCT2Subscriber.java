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
 * Subscriber for GovCT2 related events. .
 *
 * @author your_name_here
 */
@Component("govCT2-subscriber")
public class GovCT2Subscriber extends BaseSubscriber {

  public GovCT2Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovCT2>, GovCT2> govCT2Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovCT2Query(),
        ResponseTypes.multipleInstancesOf(GovCT2.class),
        ResponseTypes.instanceOf(GovCT2.class));
  }

  public SubscriptionQueryResult<GovCT2, GovCT2> govCT2Subscribe(
      @DestinationVariable UUID govCT2Id) {
    return queryGateway.subscriptionQuery(
        new FindGovCT2Query(new LoadGovCT2Filter(govCT2Id)),
        ResponseTypes.instanceOf(GovCT2.class),
        ResponseTypes.instanceOf(GovCT2.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
