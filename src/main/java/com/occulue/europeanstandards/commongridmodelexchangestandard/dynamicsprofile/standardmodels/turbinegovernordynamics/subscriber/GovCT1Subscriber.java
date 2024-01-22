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
 * Subscriber for GovCT1 related events. .
 *
 * @author your_name_here
 */
@Component("govCT1-subscriber")
public class GovCT1Subscriber extends BaseSubscriber {

  public GovCT1Subscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GovCT1>, GovCT1> govCT1Subscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGovCT1Query(),
        ResponseTypes.multipleInstancesOf(GovCT1.class),
        ResponseTypes.instanceOf(GovCT1.class));
  }

  public SubscriptionQueryResult<GovCT1, GovCT1> govCT1Subscribe(
      @DestinationVariable UUID govCT1Id) {
    return queryGateway.subscriptionQuery(
        new FindGovCT1Query(new LoadGovCT1Filter(govCT1Id)),
        ResponseTypes.instanceOf(GovCT1.class),
        ResponseTypes.instanceOf(GovCT1.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
