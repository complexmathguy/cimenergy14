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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for SeriesCompensator related events. .
 *
 * @author your_name_here
 */
@Component("seriesCompensator-subscriber")
public class SeriesCompensatorSubscriber extends BaseSubscriber {

  public SeriesCompensatorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SeriesCompensator>, SeriesCompensator>
      seriesCompensatorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSeriesCompensatorQuery(),
        ResponseTypes.multipleInstancesOf(SeriesCompensator.class),
        ResponseTypes.instanceOf(SeriesCompensator.class));
  }

  public SubscriptionQueryResult<SeriesCompensator, SeriesCompensator> seriesCompensatorSubscribe(
      @DestinationVariable UUID seriesCompensatorId) {
    return queryGateway.subscriptionQuery(
        new FindSeriesCompensatorQuery(new LoadSeriesCompensatorFilter(seriesCompensatorId)),
        ResponseTypes.instanceOf(SeriesCompensator.class),
        ResponseTypes.instanceOf(SeriesCompensator.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
