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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PerLengthDCLineParameter as outlined for the CQRS pattern. All event handling and
 * query handling related to PerLengthDCLineParameter are invoked here and dispersed as an event to
 * be handled elsewhere.
 *
 * <p>Commands are handled by PerLengthDCLineParameterAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("perLengthDCLineParameter")
@Component("perLengthDCLineParameter-projector")
public class PerLengthDCLineParameterProjector extends PerLengthDCLineParameterEntityProjector {

  // core constructor
  public PerLengthDCLineParameterProjector(
      PerLengthDCLineParameterRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePerLengthDCLineParameterEvent
   */
  @EventHandler(payloadType = CreatePerLengthDCLineParameterEvent.class)
  public void handle(CreatePerLengthDCLineParameterEvent event) {
    LOGGER.info("handling CreatePerLengthDCLineParameterEvent - " + event);
    PerLengthDCLineParameter entity = new PerLengthDCLineParameter();
    entity.setPerLengthDCLineParameterId(event.getPerLengthDCLineParameterId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerLengthDCLineParameter(entity);
  }

  /*
   * @param	event UpdatePerLengthDCLineParameterEvent
   */
  @EventHandler(payloadType = UpdatePerLengthDCLineParameterEvent.class)
  public void handle(UpdatePerLengthDCLineParameterEvent event) {
    LOGGER.info("handling UpdatePerLengthDCLineParameterEvent - " + event);

    PerLengthDCLineParameter entity = new PerLengthDCLineParameter();
    entity.setPerLengthDCLineParameterId(event.getPerLengthDCLineParameterId());
    entity.setCapacitance(event.getCapacitance());
    entity.setInductance(event.getInductance());
    entity.setResistance(event.getResistance());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPerLengthDCLineParameter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerLengthDCLineParameter(entity);
  }

  /*
   * @param	event DeletePerLengthDCLineParameterEvent
   */
  @EventHandler(payloadType = DeletePerLengthDCLineParameterEvent.class)
  public void handle(DeletePerLengthDCLineParameterEvent event) {
    LOGGER.info("handling DeletePerLengthDCLineParameterEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PerLengthDCLineParameter entity = delete(event.getPerLengthDCLineParameterId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerLengthDCLineParameter(entity);
  }

  /*
   * @param	event AssignCapacitanceToPerLengthDCLineParameterEvent
   */
  @EventHandler(payloadType = AssignCapacitanceToPerLengthDCLineParameterEvent.class)
  public void handle(AssignCapacitanceToPerLengthDCLineParameterEvent event) {
    LOGGER.info("handling AssignCapacitanceToPerLengthDCLineParameterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PerLengthDCLineParameter entity =
        assignCapacitance(event.getPerLengthDCLineParameterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPerLengthDCLineParameter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerLengthDCLineParameter(entity);
  }

  /*
   * @param	event UnAssignCapacitanceFromPerLengthDCLineParameterEvent
   */
  @EventHandler(payloadType = UnAssignCapacitanceFromPerLengthDCLineParameterEvent.class)
  public void handle(UnAssignCapacitanceFromPerLengthDCLineParameterEvent event) {
    LOGGER.info("handling UnAssignCapacitanceFromPerLengthDCLineParameterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PerLengthDCLineParameter entity = unAssignCapacitance(event.getPerLengthDCLineParameterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPerLengthDCLineParameter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerLengthDCLineParameter(entity);
  }

  /*
   * @param	event AssignInductanceToPerLengthDCLineParameterEvent
   */
  @EventHandler(payloadType = AssignInductanceToPerLengthDCLineParameterEvent.class)
  public void handle(AssignInductanceToPerLengthDCLineParameterEvent event) {
    LOGGER.info("handling AssignInductanceToPerLengthDCLineParameterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PerLengthDCLineParameter entity =
        assignInductance(event.getPerLengthDCLineParameterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPerLengthDCLineParameter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerLengthDCLineParameter(entity);
  }

  /*
   * @param	event UnAssignInductanceFromPerLengthDCLineParameterEvent
   */
  @EventHandler(payloadType = UnAssignInductanceFromPerLengthDCLineParameterEvent.class)
  public void handle(UnAssignInductanceFromPerLengthDCLineParameterEvent event) {
    LOGGER.info("handling UnAssignInductanceFromPerLengthDCLineParameterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PerLengthDCLineParameter entity = unAssignInductance(event.getPerLengthDCLineParameterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPerLengthDCLineParameter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerLengthDCLineParameter(entity);
  }

  /*
   * @param	event AssignResistanceToPerLengthDCLineParameterEvent
   */
  @EventHandler(payloadType = AssignResistanceToPerLengthDCLineParameterEvent.class)
  public void handle(AssignResistanceToPerLengthDCLineParameterEvent event) {
    LOGGER.info("handling AssignResistanceToPerLengthDCLineParameterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PerLengthDCLineParameter entity =
        assignResistance(event.getPerLengthDCLineParameterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPerLengthDCLineParameter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerLengthDCLineParameter(entity);
  }

  /*
   * @param	event UnAssignResistanceFromPerLengthDCLineParameterEvent
   */
  @EventHandler(payloadType = UnAssignResistanceFromPerLengthDCLineParameterEvent.class)
  public void handle(UnAssignResistanceFromPerLengthDCLineParameterEvent event) {
    LOGGER.info("handling UnAssignResistanceFromPerLengthDCLineParameterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PerLengthDCLineParameter entity = unAssignResistance(event.getPerLengthDCLineParameterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPerLengthDCLineParameter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPerLengthDCLineParameter(entity);
  }

  /**
   * Method to retrieve the PerLengthDCLineParameter via an PerLengthDCLineParameterPrimaryKey.
   *
   * @param id Long
   * @return PerLengthDCLineParameter
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PerLengthDCLineParameter handle(FindPerLengthDCLineParameterQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPerLengthDCLineParameterId());
  }

  /**
   * Method to retrieve a collection of all PerLengthDCLineParameters
   *
   * @param query FindAllPerLengthDCLineParameterQuery
   * @return List<PerLengthDCLineParameter>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PerLengthDCLineParameter> handle(FindAllPerLengthDCLineParameterQuery query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPerLengthDCLineParameter, but only if the id matches
   *
   * @param entity PerLengthDCLineParameter
   */
  protected void emitFindPerLengthDCLineParameter(PerLengthDCLineParameter entity) {
    LOGGER.info("handling emitFindPerLengthDCLineParameter");

    queryUpdateEmitter.emit(
        FindPerLengthDCLineParameterQuery.class,
        query ->
            query
                .getFilter()
                .getPerLengthDCLineParameterId()
                .equals(entity.getPerLengthDCLineParameterId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPerLengthDCLineParameter
   *
   * @param entity PerLengthDCLineParameter
   */
  protected void emitFindAllPerLengthDCLineParameter(PerLengthDCLineParameter entity) {
    LOGGER.info("handling emitFindAllPerLengthDCLineParameter");

    queryUpdateEmitter.emit(FindAllPerLengthDCLineParameterQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER =
      Logger.getLogger(PerLengthDCLineParameterProjector.class.getName());
}
