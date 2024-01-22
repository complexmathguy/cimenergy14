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
 * Subscriber for SwitchSchedule related events. .
 *
 * @author your_name_here
 */
@Component("switchSchedule-subscriber")
public class SwitchScheduleSubscriber extends BaseSubscriber {

  public SwitchScheduleSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SwitchSchedule>, SwitchSchedule> switchScheduleSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSwitchScheduleQuery(),
        ResponseTypes.multipleInstancesOf(SwitchSchedule.class),
        ResponseTypes.instanceOf(SwitchSchedule.class));
  }

  public SubscriptionQueryResult<SwitchSchedule, SwitchSchedule> switchScheduleSubscribe(
      @DestinationVariable UUID switchScheduleId) {
    return queryGateway.subscriptionQuery(
        new FindSwitchScheduleQuery(new LoadSwitchScheduleFilter(switchScheduleId)),
        ResponseTypes.instanceOf(SwitchSchedule.class),
        ResponseTypes.instanceOf(SwitchSchedule.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
