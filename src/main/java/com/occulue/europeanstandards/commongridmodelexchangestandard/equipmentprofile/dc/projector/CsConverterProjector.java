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
 * Projector for CsConverter as outlined for the CQRS pattern. All event handling and query handling
 * related to CsConverter are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by CsConverterAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("csConverter")
@Component("csConverter-projector")
public class CsConverterProjector extends CsConverterEntityProjector {

  // core constructor
  public CsConverterProjector(
      CsConverterRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateCsConverterEvent
   */
  @EventHandler(payloadType = CreateCsConverterEvent.class)
  public void handle(CreateCsConverterEvent event) {
    LOGGER.info("handling CreateCsConverterEvent - " + event);
    CsConverter entity = new CsConverter();
    entity.setCsConverterId(event.getCsConverterId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event UpdateCsConverterEvent
   */
  @EventHandler(payloadType = UpdateCsConverterEvent.class)
  public void handle(UpdateCsConverterEvent event) {
    LOGGER.info("handling UpdateCsConverterEvent - " + event);

    CsConverter entity = new CsConverter();
    entity.setCsConverterId(event.getCsConverterId());
    entity.setMaxAlpha(event.getMaxAlpha());
    entity.setMaxGamma(event.getMaxGamma());
    entity.setMaxIdc(event.getMaxIdc());
    entity.setMinAlpha(event.getMinAlpha());
    entity.setMinGamma(event.getMinGamma());
    entity.setMinIdc(event.getMinIdc());
    entity.setRatedIdc(event.getRatedIdc());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event DeleteCsConverterEvent
   */
  @EventHandler(payloadType = DeleteCsConverterEvent.class)
  public void handle(DeleteCsConverterEvent event) {
    LOGGER.info("handling DeleteCsConverterEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    CsConverter entity = delete(event.getCsConverterId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event AssignMaxAlphaToCsConverterEvent
   */
  @EventHandler(payloadType = AssignMaxAlphaToCsConverterEvent.class)
  public void handle(AssignMaxAlphaToCsConverterEvent event) {
    LOGGER.info("handling AssignMaxAlphaToCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CsConverter entity = assignMaxAlpha(event.getCsConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event UnAssignMaxAlphaFromCsConverterEvent
   */
  @EventHandler(payloadType = UnAssignMaxAlphaFromCsConverterEvent.class)
  public void handle(UnAssignMaxAlphaFromCsConverterEvent event) {
    LOGGER.info("handling UnAssignMaxAlphaFromCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CsConverter entity = unAssignMaxAlpha(event.getCsConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event AssignMaxGammaToCsConverterEvent
   */
  @EventHandler(payloadType = AssignMaxGammaToCsConverterEvent.class)
  public void handle(AssignMaxGammaToCsConverterEvent event) {
    LOGGER.info("handling AssignMaxGammaToCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CsConverter entity = assignMaxGamma(event.getCsConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event UnAssignMaxGammaFromCsConverterEvent
   */
  @EventHandler(payloadType = UnAssignMaxGammaFromCsConverterEvent.class)
  public void handle(UnAssignMaxGammaFromCsConverterEvent event) {
    LOGGER.info("handling UnAssignMaxGammaFromCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CsConverter entity = unAssignMaxGamma(event.getCsConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event AssignMaxIdcToCsConverterEvent
   */
  @EventHandler(payloadType = AssignMaxIdcToCsConverterEvent.class)
  public void handle(AssignMaxIdcToCsConverterEvent event) {
    LOGGER.info("handling AssignMaxIdcToCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CsConverter entity = assignMaxIdc(event.getCsConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event UnAssignMaxIdcFromCsConverterEvent
   */
  @EventHandler(payloadType = UnAssignMaxIdcFromCsConverterEvent.class)
  public void handle(UnAssignMaxIdcFromCsConverterEvent event) {
    LOGGER.info("handling UnAssignMaxIdcFromCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CsConverter entity = unAssignMaxIdc(event.getCsConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event AssignMinAlphaToCsConverterEvent
   */
  @EventHandler(payloadType = AssignMinAlphaToCsConverterEvent.class)
  public void handle(AssignMinAlphaToCsConverterEvent event) {
    LOGGER.info("handling AssignMinAlphaToCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CsConverter entity = assignMinAlpha(event.getCsConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event UnAssignMinAlphaFromCsConverterEvent
   */
  @EventHandler(payloadType = UnAssignMinAlphaFromCsConverterEvent.class)
  public void handle(UnAssignMinAlphaFromCsConverterEvent event) {
    LOGGER.info("handling UnAssignMinAlphaFromCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CsConverter entity = unAssignMinAlpha(event.getCsConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event AssignMinGammaToCsConverterEvent
   */
  @EventHandler(payloadType = AssignMinGammaToCsConverterEvent.class)
  public void handle(AssignMinGammaToCsConverterEvent event) {
    LOGGER.info("handling AssignMinGammaToCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CsConverter entity = assignMinGamma(event.getCsConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event UnAssignMinGammaFromCsConverterEvent
   */
  @EventHandler(payloadType = UnAssignMinGammaFromCsConverterEvent.class)
  public void handle(UnAssignMinGammaFromCsConverterEvent event) {
    LOGGER.info("handling UnAssignMinGammaFromCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CsConverter entity = unAssignMinGamma(event.getCsConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event AssignMinIdcToCsConverterEvent
   */
  @EventHandler(payloadType = AssignMinIdcToCsConverterEvent.class)
  public void handle(AssignMinIdcToCsConverterEvent event) {
    LOGGER.info("handling AssignMinIdcToCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CsConverter entity = assignMinIdc(event.getCsConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event UnAssignMinIdcFromCsConverterEvent
   */
  @EventHandler(payloadType = UnAssignMinIdcFromCsConverterEvent.class)
  public void handle(UnAssignMinIdcFromCsConverterEvent event) {
    LOGGER.info("handling UnAssignMinIdcFromCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CsConverter entity = unAssignMinIdc(event.getCsConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event AssignRatedIdcToCsConverterEvent
   */
  @EventHandler(payloadType = AssignRatedIdcToCsConverterEvent.class)
  public void handle(AssignRatedIdcToCsConverterEvent event) {
    LOGGER.info("handling AssignRatedIdcToCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    CsConverter entity = assignRatedIdc(event.getCsConverterId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /*
   * @param	event UnAssignRatedIdcFromCsConverterEvent
   */
  @EventHandler(payloadType = UnAssignRatedIdcFromCsConverterEvent.class)
  public void handle(UnAssignRatedIdcFromCsConverterEvent event) {
    LOGGER.info("handling UnAssignRatedIdcFromCsConverterEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    CsConverter entity = unAssignRatedIdc(event.getCsConverterId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindCsConverter(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllCsConverter(entity);
  }

  /**
   * Method to retrieve the CsConverter via an CsConverterPrimaryKey.
   *
   * @param id Long
   * @return CsConverter
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public CsConverter handle(FindCsConverterQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getCsConverterId());
  }

  /**
   * Method to retrieve a collection of all CsConverters
   *
   * @param query FindAllCsConverterQuery
   * @return List<CsConverter>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<CsConverter> handle(FindAllCsConverterQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindCsConverter, but only if the id matches
   *
   * @param entity CsConverter
   */
  protected void emitFindCsConverter(CsConverter entity) {
    LOGGER.info("handling emitFindCsConverter");

    queryUpdateEmitter.emit(
        FindCsConverterQuery.class,
        query -> query.getFilter().getCsConverterId().equals(entity.getCsConverterId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllCsConverter
   *
   * @param entity CsConverter
   */
  protected void emitFindAllCsConverter(CsConverter entity) {
    LOGGER.info("handling emitFindAllCsConverter");

    queryUpdateEmitter.emit(FindAllCsConverterQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(CsConverterProjector.class.getName());
}
