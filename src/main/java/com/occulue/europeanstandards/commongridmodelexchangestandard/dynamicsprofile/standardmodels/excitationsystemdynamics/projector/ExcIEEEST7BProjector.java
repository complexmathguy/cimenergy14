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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcIEEEST7B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEST7B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEST7BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEST7B")
@Component("excIEEEST7B-projector")
public class ExcIEEEST7BProjector extends ExcIEEEST7BEntityProjector {

  // core constructor
  public ExcIEEEST7BProjector(
      ExcIEEEST7BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEST7BEvent
   */
  @EventHandler(payloadType = CreateExcIEEEST7BEvent.class)
  public void handle(CreateExcIEEEST7BEvent event) {
    LOGGER.info("handling CreateExcIEEEST7BEvent - " + event);
    ExcIEEEST7B entity = new ExcIEEEST7B();
    entity.setExcIEEEST7BId(event.getExcIEEEST7BId());
    entity.setOelin(event.getOelin());
    entity.setUelin(event.getUelin());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UpdateExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEST7BEvent.class)
  public void handle(UpdateExcIEEEST7BEvent event) {
    LOGGER.info("handling UpdateExcIEEEST7BEvent - " + event);

    ExcIEEEST7B entity = new ExcIEEEST7B();
    entity.setExcIEEEST7BId(event.getExcIEEEST7BId());
    entity.setKh(event.getKh());
    entity.setKia(event.getKia());
    entity.setKl(event.getKl());
    entity.setKpa(event.getKpa());
    entity.setOelin(event.getOelin());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTf(event.getTf());
    entity.setTg(event.getTg());
    entity.setTia(event.getTia());
    entity.setUelin(event.getUelin());
    entity.setVmax(event.getVmax());
    entity.setVmin(event.getVmin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event DeleteExcIEEEST7BEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEST7BEvent.class)
  public void handle(DeleteExcIEEEST7BEvent event) {
    LOGGER.info("handling DeleteExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEST7B entity = delete(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignKhToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignKhToExcIEEEST7BEvent.class)
  public void handle(AssignKhToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignKhToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignKh(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignKhFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignKhFromExcIEEEST7BEvent.class)
  public void handle(UnAssignKhFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignKhFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignKh(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignKiaToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignKiaToExcIEEEST7BEvent.class)
  public void handle(AssignKiaToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignKiaToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignKia(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignKiaFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignKiaFromExcIEEEST7BEvent.class)
  public void handle(UnAssignKiaFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignKiaFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignKia(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignKlToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignKlToExcIEEEST7BEvent.class)
  public void handle(AssignKlToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignKlToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignKl(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignKlFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignKlFromExcIEEEST7BEvent.class)
  public void handle(UnAssignKlFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignKlFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignKl(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignKpaToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignKpaToExcIEEEST7BEvent.class)
  public void handle(AssignKpaToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignKpaToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignKpa(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignKpaFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignKpaFromExcIEEEST7BEvent.class)
  public void handle(UnAssignKpaFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignKpaFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignKpa(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEST7BEvent.class)
  public void handle(AssignTbToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignTb(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEST7BEvent.class)
  public void handle(UnAssignTbFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignTb(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEST7BEvent.class)
  public void handle(AssignTcToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignTc(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEST7BEvent.class)
  public void handle(UnAssignTcFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignTc(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEST7BEvent.class)
  public void handle(AssignTfToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignTf(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEST7BEvent.class)
  public void handle(UnAssignTfFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignTf(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignTgToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignTgToExcIEEEST7BEvent.class)
  public void handle(AssignTgToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignTgToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignTg(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignTgFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignTgFromExcIEEEST7BEvent.class)
  public void handle(UnAssignTgFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignTgFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignTg(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignTiaToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignTiaToExcIEEEST7BEvent.class)
  public void handle(AssignTiaToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignTiaToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignTia(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignTiaFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignTiaFromExcIEEEST7BEvent.class)
  public void handle(UnAssignTiaFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignTiaFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignTia(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignVmaxToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignVmaxToExcIEEEST7BEvent.class)
  public void handle(AssignVmaxToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignVmaxToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignVmax(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignVmaxFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignVmaxFromExcIEEEST7BEvent.class)
  public void handle(UnAssignVmaxFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignVmaxFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignVmax(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignVminToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignVminToExcIEEEST7BEvent.class)
  public void handle(AssignVminToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignVminToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignVmin(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignVminFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignVminFromExcIEEEST7BEvent.class)
  public void handle(UnAssignVminFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignVminFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignVmin(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEST7BEvent.class)
  public void handle(AssignVrmaxToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignVrmax(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEST7BEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignVrmax(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEST7BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEST7BEvent.class)
  public void handle(AssignVrminToExcIEEEST7BEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST7B entity = assignVrmin(event.getExcIEEEST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEST7BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEST7BEvent.class)
  public void handle(UnAssignVrminFromExcIEEEST7BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST7B entity = unAssignVrmin(event.getExcIEEEST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST7B(entity);
  }

  /**
   * Method to retrieve the ExcIEEEST7B via an ExcIEEEST7BPrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEST7B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEST7B handle(FindExcIEEEST7BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEST7BId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST7Bs
   *
   * @param query FindAllExcIEEEST7BQuery
   * @return List<ExcIEEEST7B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEST7B> handle(FindAllExcIEEEST7BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEST7B, but only if the id matches
   *
   * @param entity ExcIEEEST7B
   */
  protected void emitFindExcIEEEST7B(ExcIEEEST7B entity) {
    LOGGER.info("handling emitFindExcIEEEST7B");

    queryUpdateEmitter.emit(
        FindExcIEEEST7BQuery.class,
        query -> query.getFilter().getExcIEEEST7BId().equals(entity.getExcIEEEST7BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEST7B
   *
   * @param entity ExcIEEEST7B
   */
  protected void emitFindAllExcIEEEST7B(ExcIEEEST7B entity) {
    LOGGER.info("handling emitFindAllExcIEEEST7B");

    queryUpdateEmitter.emit(FindAllExcIEEEST7BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST7BProjector.class.getName());
}
