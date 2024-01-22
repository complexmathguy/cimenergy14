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
 * Subscriber for RegulationSchedule related events. .
 *
 * @author your_name_here
 */
@Component("regulationSchedule-subscriber")
public class RegulationScheduleSubscriber extends BaseSubscriber {

  public RegulationScheduleSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RegulationSchedule>, RegulationSchedule>
      regulationScheduleSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRegulationScheduleQuery(),
        ResponseTypes.multipleInstancesOf(RegulationSchedule.class),
        ResponseTypes.instanceOf(RegulationSchedule.class));
  }

  public SubscriptionQueryResult<RegulationSchedule, RegulationSchedule>
      regulationScheduleSubscribe(@DestinationVariable UUID regulationScheduleId) {
    return queryGateway.subscriptionQuery(
        new FindRegulationScheduleQuery(new LoadRegulationScheduleFilter(regulationScheduleId)),
        ResponseTypes.instanceOf(RegulationSchedule.class),
        ResponseTypes.instanceOf(RegulationSchedule.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
