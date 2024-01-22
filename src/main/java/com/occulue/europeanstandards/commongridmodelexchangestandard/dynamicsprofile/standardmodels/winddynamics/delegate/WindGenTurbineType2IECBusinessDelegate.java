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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
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
 * WindGenTurbineType2IEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindGenTurbineType2IEC related services in the case of a
 *       WindGenTurbineType2IEC business related service failing.
 *   <li>Exposes a simpler, uniform WindGenTurbineType2IEC interface to the business tier, making it
 *       easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindGenTurbineType2IEC
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindGenTurbineType2IECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindGenTurbineType2IECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindGenTurbineType2IEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindGenTurbineType2IECBusinessDelegate
   */
  public static WindGenTurbineType2IECBusinessDelegate getWindGenTurbineType2IECInstance() {
    return (new WindGenTurbineType2IECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindGenTurbineType2IEC(
      CreateWindGenTurbineType2IECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindGenTurbineType2IECId() == null)
        command.setWindGenTurbineType2IECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType2IECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindGenTurbineType2IECCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindGenTurbineType2IECCommand of WindGenTurbineType2IEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindGenTurbineType2IEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindGenTurbineType2IECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindGenTurbineType2IEC(
      UpdateWindGenTurbineType2IECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindGenTurbineType2IECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindGenTurbineType2IECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindGenTurbineType2IEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindGenTurbineType2IECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindGenTurbineType2IECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType2IECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindGenTurbineType2IECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindGenTurbineType2IEC using Id = "
              + command.getWindGenTurbineType2IECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindGenTurbineType2IEC via WindGenTurbineType2IECFetchOneSummary
   *
   * @param summary WindGenTurbineType2IECFetchOneSummary
   * @return WindGenTurbineType2IECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindGenTurbineType2IEC getWindGenTurbineType2IEC(
      WindGenTurbineType2IECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "WindGenTurbineType2IECFetchOneSummary arg cannot be null");

    WindGenTurbineType2IEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindGenTurbineType2IECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindGenTurbineType2IEC
      // --------------------------------------
      CompletableFuture<WindGenTurbineType2IEC> futureEntity =
          queryGateway.query(
              new FindWindGenTurbineType2IECQuery(
                  new LoadWindGenTurbineType2IECFilter(summary.getWindGenTurbineType2IECId())),
              ResponseTypes.instanceOf(WindGenTurbineType2IEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate WindGenTurbineType2IEC with id "
              + summary.getWindGenTurbineType2IECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindGenTurbineType2IECs
   *
   * @return List<WindGenTurbineType2IEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindGenTurbineType2IEC> getAllWindGenTurbineType2IEC() throws ProcessingException {
    List<WindGenTurbineType2IEC> list = null;

    try {
      CompletableFuture<List<WindGenTurbineType2IEC>> futureList =
          queryGateway.query(
              new FindAllWindGenTurbineType2IECQuery(),
              ResponseTypes.multipleInstancesOf(WindGenTurbineType2IEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindGenTurbineType2IEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign WindGenTurbineType2IEC on WindGenTurbineType2IEC
   *
   * @param command AssignWindGenTurbineType2IECToWindGenTurbineType2IECCommand
   * @exception ProcessingException
   */
  public void assignWindGenTurbineType2IEC(
      AssignWindGenTurbineType2IECToWindGenTurbineType2IECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindGenTurbineType2IECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .winddynamics.delegate.WindGenTurbineType2IECBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.winddynamics.delegate.WindGenTurbineType2IECBusinessDelegate
                .getWindGenTurbineType2IECInstance();
    WindGenTurbineType2IECBusinessDelegate parentDelegate =
        WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance();
    UUID childId = command.getAssignment().getWindGenTurbineType2IECId();
    WindGenTurbineType2IEC child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindGenTurbineType2IECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get WindGenTurbineType2IEC using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign WindGenTurbineType2IEC on WindGenTurbineType2IEC
   *
   * @param command UnAssignWindGenTurbineType2IECFromWindGenTurbineType2IECCommand
   * @exception ProcessingException
   */
  public void unAssignWindGenTurbineType2IEC(
      UnAssignWindGenTurbineType2IECFromWindGenTurbineType2IECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindGenTurbineType2IECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign WindGenTurbineType2IEC on WindGenTurbineType2IEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindGenTurbineType2IEC
   */
  private WindGenTurbineType2IEC load(UUID id) throws ProcessingException {
    windGenTurbineType2IEC =
        WindGenTurbineType2IECBusinessDelegate.getWindGenTurbineType2IECInstance()
            .getWindGenTurbineType2IEC(new WindGenTurbineType2IECFetchOneSummary(id));
    return windGenTurbineType2IEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindGenTurbineType2IEC windGenTurbineType2IEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindGenTurbineType2IECBusinessDelegate.class.getName());
}
