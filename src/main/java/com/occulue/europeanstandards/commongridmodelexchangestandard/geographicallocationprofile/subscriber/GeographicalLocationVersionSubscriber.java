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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.subscriber;

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
 * Subscriber for GeographicalLocationVersion related events. .
 *
 * @author your_name_here
 */
@Component("geographicalLocationVersion-subscriber")
public class GeographicalLocationVersionSubscriber extends BaseSubscriber {

  public GeographicalLocationVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<GeographicalLocationVersion>, GeographicalLocationVersion>
      geographicalLocationVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGeographicalLocationVersionQuery(),
        ResponseTypes.multipleInstancesOf(GeographicalLocationVersion.class),
        ResponseTypes.instanceOf(GeographicalLocationVersion.class));
  }

  public SubscriptionQueryResult<GeographicalLocationVersion, GeographicalLocationVersion>
      geographicalLocationVersionSubscribe(
          @DestinationVariable UUID geographicalLocationVersionId) {
    return queryGateway.subscriptionQuery(
        new FindGeographicalLocationVersionQuery(
            new LoadGeographicalLocationVersionFilter(geographicalLocationVersionId)),
        ResponseTypes.instanceOf(GeographicalLocationVersion.class),
        ResponseTypes.instanceOf(GeographicalLocationVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
