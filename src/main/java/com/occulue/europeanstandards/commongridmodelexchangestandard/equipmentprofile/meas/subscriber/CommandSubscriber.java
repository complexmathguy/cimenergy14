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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.subscriber;

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
 * Subscriber for Command related events. .
 *
 * @author your_name_here
 */
@Component("command-subscriber")
public class CommandSubscriber extends BaseSubscriber {

  public CommandSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Command>, Command> commandSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllCommandQuery(),
        ResponseTypes.multipleInstancesOf(Command.class),
        ResponseTypes.instanceOf(Command.class));
  }

  public SubscriptionQueryResult<Command, Command> commandSubscribe(
      @DestinationVariable UUID commandId) {
    return queryGateway.subscriptionQuery(
        new FindCommandQuery(new LoadCommandFilter(commandId)),
        ResponseTypes.instanceOf(Command.class),
        ResponseTypes.instanceOf(Command.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
