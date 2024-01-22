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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for WindTurbineType4bIEC as outlined for the CQRS pattern. All event handling and query
 * handling related to WindTurbineType4bIEC are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by WindTurbineType4bIECAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("windTurbineType4bIEC")
@Component("windTurbineType4bIEC-projector")
public class WindTurbineType4bIECProjector extends WindTurbineType4bIECEntityProjector {

  // core constructor
  public WindTurbineType4bIECProjector(
      WindTurbineType4bIECRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateWindTurbineType4bIECEvent
   */
  @EventHandler(payloadType = CreateWindTurbineType4bIECEvent.class)
  public void handle(CreateWindTurbineType4bIECEvent event) {
    LOGGER.info("handling CreateWindTurbineType4bIECEvent - " + event);
    WindTurbineType4bIEC entity = new WindTurbineType4bIEC();
    entity.setWindTurbineType4bIECId(event.getWindTurbineType4bIECId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType4bIEC(entity);
  }

  /*
   * @param	event UpdateWindTurbineType4bIECEvent
   */
  @EventHandler(payloadType = UpdateWindTurbineType4bIECEvent.class)
  public void handle(UpdateWindTurbineType4bIECEvent event) {
    LOGGER.info("handling UpdateWindTurbineType4bIECEvent - " + event);

    WindTurbineType4bIEC entity = new WindTurbineType4bIEC();
    entity.setWindTurbineType4bIECId(event.getWindTurbineType4bIECId());
    entity.setWindTurbineType4bIEC(event.getWindTurbineType4bIEC());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindTurbineType4bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType4bIEC(entity);
  }

  /*
   * @param	event DeleteWindTurbineType4bIECEvent
   */
  @EventHandler(payloadType = DeleteWindTurbineType4bIECEvent.class)
  public void handle(DeleteWindTurbineType4bIECEvent event) {
    LOGGER.info("handling DeleteWindTurbineType4bIECEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    WindTurbineType4bIEC entity = delete(event.getWindTurbineType4bIECId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType4bIEC(entity);
  }

  /*
   * @param	event AssignWindTurbineType4bIECToWindTurbineType4bIECEvent
   */
  @EventHandler(payloadType = AssignWindTurbineType4bIECToWindTurbineType4bIECEvent.class)
  public void handle(AssignWindTurbineType4bIECToWindTurbineType4bIECEvent event) {
    LOGGER.info("handling AssignWindTurbineType4bIECToWindTurbineType4bIECEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    WindTurbineType4bIEC entity =
        assignWindTurbineType4bIEC(event.getWindTurbineType4bIECId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindTurbineType4bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType4bIEC(entity);
  }

  /*
   * @param	event UnAssignWindTurbineType4bIECFromWindTurbineType4bIECEvent
   */
  @EventHandler(payloadType = UnAssignWindTurbineType4bIECFromWindTurbineType4bIECEvent.class)
  public void handle(UnAssignWindTurbineType4bIECFromWindTurbineType4bIECEvent event) {
    LOGGER.info("handling UnAssignWindTurbineType4bIECFromWindTurbineType4bIECEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    WindTurbineType4bIEC entity = unAssignWindTurbineType4bIEC(event.getWindTurbineType4bIECId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindWindTurbineType4bIEC(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllWindTurbineType4bIEC(entity);
  }

  /**
   * Method to retrieve the WindTurbineType4bIEC via an WindTurbineType4bIECPrimaryKey.
   *
   * @param id Long
   * @return WindTurbineType4bIEC
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public WindTurbineType4bIEC handle(FindWindTurbineType4bIECQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getWindTurbineType4bIECId());
  }

  /**
   * Method to retrieve a collection of all WindTurbineType4bIECs
   *
   * @param query FindAllWindTurbineType4bIECQuery
   * @return List<WindTurbineType4bIEC>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<WindTurbineType4bIEC> handle(FindAllWindTurbineType4bIECQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindWindTurbineType4bIEC, but only if the id matches
   *
   * @param entity WindTurbineType4bIEC
   */
  protected void emitFindWindTurbineType4bIEC(WindTurbineType4bIEC entity) {
    LOGGER.info("handling emitFindWindTurbineType4bIEC");

    queryUpdateEmitter.emit(
        FindWindTurbineType4bIECQuery.class,
        query ->
            query
                .getFilter()
                .getWindTurbineType4bIECId()
                .equals(entity.getWindTurbineType4bIECId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllWindTurbineType4bIEC
   *
   * @param entity WindTurbineType4bIEC
   */
  protected void emitFindAllWindTurbineType4bIEC(WindTurbineType4bIEC entity) {
    LOGGER.info("handling emitFindAllWindTurbineType4bIEC");

    queryUpdateEmitter.emit(FindAllWindTurbineType4bIECQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(WindTurbineType4bIECProjector.class.getName());
}
