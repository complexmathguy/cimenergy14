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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * GrossToNetActivePowerCurve business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of GrossToNetActivePowerCurve related services in the case of a
 *       GrossToNetActivePowerCurve business related service failing.
 *   <li>Exposes a simpler, uniform GrossToNetActivePowerCurve interface to the business tier,
 *       making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill GrossToNetActivePowerCurve
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class GrossToNetActivePowerCurveBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public GrossToNetActivePowerCurveBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * GrossToNetActivePowerCurve Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return GrossToNetActivePowerCurveBusinessDelegate
   */
  public static GrossToNetActivePowerCurveBusinessDelegate getGrossToNetActivePowerCurveInstance() {
    return (new GrossToNetActivePowerCurveBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createGrossToNetActivePowerCurve(
      CreateGrossToNetActivePowerCurveCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getGrossToNetActivePowerCurveId() == null)
        command.setGrossToNetActivePowerCurveId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GrossToNetActivePowerCurveValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateGrossToNetActivePowerCurveCommand - by convention the future return value
      // for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateGrossToNetActivePowerCurveCommand of GrossToNetActivePowerCurve is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create GrossToNetActivePowerCurve - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateGrossToNetActivePowerCurveCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateGrossToNetActivePowerCurve(
      UpdateGrossToNetActivePowerCurveCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      GrossToNetActivePowerCurveValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateGrossToNetActivePowerCurveCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save GrossToNetActivePowerCurve - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteGrossToNetActivePowerCurveCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteGrossToNetActivePowerCurveCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GrossToNetActivePowerCurveValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteGrossToNetActivePowerCurveCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete GrossToNetActivePowerCurve using Id = "
              + command.getGrossToNetActivePowerCurveId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the GrossToNetActivePowerCurve via GrossToNetActivePowerCurveFetchOneSummary
   *
   * @param summary GrossToNetActivePowerCurveFetchOneSummary
   * @return GrossToNetActivePowerCurveFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public GrossToNetActivePowerCurve getGrossToNetActivePowerCurve(
      GrossToNetActivePowerCurveFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "GrossToNetActivePowerCurveFetchOneSummary arg cannot be null");

    GrossToNetActivePowerCurve entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      GrossToNetActivePowerCurveValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a GrossToNetActivePowerCurve
      // --------------------------------------
      CompletableFuture<GrossToNetActivePowerCurve> futureEntity =
          queryGateway.query(
              new FindGrossToNetActivePowerCurveQuery(
                  new LoadGrossToNetActivePowerCurveFilter(
                      summary.getGrossToNetActivePowerCurveId())),
              ResponseTypes.instanceOf(GrossToNetActivePowerCurve.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate GrossToNetActivePowerCurve with id "
              + summary.getGrossToNetActivePowerCurveId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all GrossToNetActivePowerCurves
   *
   * @return List<GrossToNetActivePowerCurve>
   * @exception ProcessingException Thrown if any problems
   */
  public List<GrossToNetActivePowerCurve> getAllGrossToNetActivePowerCurve()
      throws ProcessingException {
    List<GrossToNetActivePowerCurve> list = null;

    try {
      CompletableFuture<List<GrossToNetActivePowerCurve>> futureList =
          queryGateway.query(
              new FindAllGrossToNetActivePowerCurveQuery(),
              ResponseTypes.multipleInstancesOf(GrossToNetActivePowerCurve.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all GrossToNetActivePowerCurve";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add GrossToNetActivePowerCurve to GrossToNetActivePowerCurves
   *
   * @param command AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveCommand
   * @exception ProcessingException
   */
  public void addToGrossToNetActivePowerCurves(
      AssignGrossToNetActivePowerCurvesToGrossToNetActivePowerCurveCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getGrossToNetActivePowerCurveId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
            .delegate.GrossToNetActivePowerCurveBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .production.delegate.GrossToNetActivePowerCurveBusinessDelegate
                .getGrossToNetActivePowerCurveInstance();
    GrossToNetActivePowerCurveBusinessDelegate parentDelegate =
        GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance();
    UUID childId = command.getAddTo().getGrossToNetActivePowerCurveId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      GrossToNetActivePowerCurveValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a GrossToNetActivePowerCurve as GrossToNetActivePowerCurves to GrossToNetActivePowerCurve";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove GrossToNetActivePowerCurve from GrossToNetActivePowerCurves
   *
   * @param command RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand
   * @exception ProcessingException
   */
  public void removeFromGrossToNetActivePowerCurves(
      RemoveGrossToNetActivePowerCurvesFromGrossToNetActivePowerCurveCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production
            .delegate.GrossToNetActivePowerCurveBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile
                .production.delegate.GrossToNetActivePowerCurveBusinessDelegate
                .getGrossToNetActivePowerCurveInstance();
    UUID childId = command.getRemoveFrom().getGrossToNetActivePowerCurveId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      GrossToNetActivePowerCurveValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return GrossToNetActivePowerCurve
   */
  private GrossToNetActivePowerCurve load(UUID id) throws ProcessingException {
    grossToNetActivePowerCurve =
        GrossToNetActivePowerCurveBusinessDelegate.getGrossToNetActivePowerCurveInstance()
            .getGrossToNetActivePowerCurve(new GrossToNetActivePowerCurveFetchOneSummary(id));
    return grossToNetActivePowerCurve;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private GrossToNetActivePowerCurve grossToNetActivePowerCurve = null;
  private static final Logger LOGGER =
      Logger.getLogger(GrossToNetActivePowerCurveBusinessDelegate.class.getName());
}
