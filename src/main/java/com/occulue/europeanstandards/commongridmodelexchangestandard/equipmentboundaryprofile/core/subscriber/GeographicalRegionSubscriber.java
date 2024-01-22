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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.subscriber;

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
 * Subscriber for GeographicalRegion related events. .
 *
 * @author your_name_here
 */
@Component("geographicalRegion-subscriber")
public class GeographicalRegionSubscriber extends BaseSubscriber {

  public GeographicalRegionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GeographicalRegion>, GeographicalRegion>
      geographicalRegionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGeographicalRegionQuery(),
        ResponseTypes.multipleInstancesOf(GeographicalRegion.class),
        ResponseTypes.instanceOf(GeographicalRegion.class));
  }

  public SubscriptionQueryResult<GeographicalRegion, GeographicalRegion>
      geographicalRegionSubscribe(@DestinationVariable UUID geographicalRegionId) {
    return queryGateway.subscriptionQuery(
        new FindGeographicalRegionQuery(new LoadGeographicalRegionFilter(geographicalRegionId)),
        ResponseTypes.instanceOf(GeographicalRegion.class),
        ResponseTypes.instanceOf(GeographicalRegion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
