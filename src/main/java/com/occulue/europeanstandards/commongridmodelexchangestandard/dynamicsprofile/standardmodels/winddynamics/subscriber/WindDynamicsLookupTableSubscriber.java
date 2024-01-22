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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.subscriber;

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
 * Subscriber for WindDynamicsLookupTable related events. .
 *
 * @author your_name_here
 */
@Component("windDynamicsLookupTable-subscriber")
public class WindDynamicsLookupTableSubscriber extends BaseSubscriber {

  public WindDynamicsLookupTableSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindDynamicsLookupTable>, WindDynamicsLookupTable>
      windDynamicsLookupTableSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindDynamicsLookupTableQuery(),
        ResponseTypes.multipleInstancesOf(WindDynamicsLookupTable.class),
        ResponseTypes.instanceOf(WindDynamicsLookupTable.class));
  }

  public SubscriptionQueryResult<WindDynamicsLookupTable, WindDynamicsLookupTable>
      windDynamicsLookupTableSubscribe(@DestinationVariable UUID windDynamicsLookupTableId) {
    return queryGateway.subscriptionQuery(
        new FindWindDynamicsLookupTableQuery(
            new LoadWindDynamicsLookupTableFilter(windDynamicsLookupTableId)),
        ResponseTypes.instanceOf(WindDynamicsLookupTable.class),
        ResponseTypes.instanceOf(WindDynamicsLookupTable.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
